import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AirJoin {
    public static void main(String[] args) throws Exception {
        if(args.length != 3) {
            System.err.println("args");
            System.exit(-1);
        }

        Job job = Job.getInstance();
        job.setJarByClass(AirJoin.class);
        job.setJobName("AirJoin");

        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, FlyMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));


        job.setPartitionerClass(AirPartitioner.class);
        job.setGroupingComparatorClass(AirGC.class);
        job.setReducerClass(AirReducer.class);
        job.setMapOutputKeyClass(AirWC.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
//hadoop fs -rm -r -f /user/knl/output
//mvn package
//hadoop fs -copyFromLocal AIR.csv
//hadoop fs -copyFromLocal TIME.csv
//export HADOOP_CLASSPATH=target/hadoop-examples-1.0-SNAPSHOT.jar
//hadoop AirJoin AIR.csv TIME.csv output
//hadoop fs -copyToLocal output
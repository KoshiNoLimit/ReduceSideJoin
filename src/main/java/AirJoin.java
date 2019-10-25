import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AirJoin {
    public static void main(String[] args) throws Exception {
        if(args.length !=2) {
            System.err.println("args");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(AirJoin.class);
        job.setJobName("AirJoin");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setPartitionerClass(AirPartitioner.class);
        job.setGroupingComparatorClass(AirGC.class);
        job.setReducerClass(AirReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

//Fortune files are text files with random sayings and quotes in them, where each entry is separated by a line
//containing only a percent sign (%). See the file /opt/local/share/games/fortune/fortunes in the lab for an example.
//Note there are also fortune files that end in -o that contain quotes that could be considered offensive. These files
//have had a trivial encryption applied to prevent accidental reading (it would be nice if they were not part of the
//fortune install at all). So do not go looking at them unless you are willing to be offended. Your task is to modify
//your cowsay program to display a random quote from the fortune file fortunes.txt in your program's current working
//directory (the directory it is run from, most IDEs will let you set this for testing as well). If the fortunes.txt
//file does not exists, then your program should print an informative error message and quit. Your cowsay program now
//has to handle multi-line messages (as most fortunes have a few lines). Your program also has to handle two optional
//command line arguments. If the String "debug" is given as an argument then information about the number of fortunes
//in the fortunes.txt file and which fortune number was selected must be printed along with the regular output (note
//fortune numbers start at 1). Additionally, if an integer is given as a command line argument, then that is the fortune
//number that should be printed (i.e. not a random one). All other command line arguments should be ignored. You can
//make and submit your own non-offensive fortunes.txt file or use one of the non-offensive files from the lab. However,
//you should expect that I will also test you program with my own files. Also, note that while the real fortune program
//uses precomputed offsets to make look ups fast, you can take multiple passes over the data file to get the information
//you need.

public class Exercise02 {

    public static void main(String[] arguments) {

    }
}
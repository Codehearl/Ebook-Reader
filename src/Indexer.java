import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class Indexer {
    private List<Token> tokens;
    private List<InvertedIndex> InvertedIndexes;
    private String RootDirectory = "";
    //TODO complete indexer, by creating the different document types and adding them to the inverted indexes
    public  void Index(){
        File directory = new File(RootDirectory);
        if(directory.exists() && directory.isDirectory()){
            File files[] = directory.listFiles();
        }
    }
    /**
     *get the extension of the file
     * @param file
     * @return
     */
    private String getExtension(File file){

        Path path = file.toPath();


        String filename = path.getFileName().toString();

        String extension = "";
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex >= 0 && dotIndex < filename.length() - 1) {
            extension = filename.substring(dotIndex + 1);
        }
        return extension;

    }


}

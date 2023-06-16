import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

abstract class Document {
    private List<String> _token;
    private String filepath;

    private String filename;

    public Document(File file) {
        this.filepath = file.getPath();
        this.filename = file.getName();

    }

    private String getExtension(String filepath){
        Assertions.assertNotNull(filepath);
        Path path = Path.of(filepath);

        // Get the filename from the Path object
        String filename = path.getFileName().toString();

        // Get the file extension from the filename
        String extension = "";
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex >= 0 && dotIndex < filename.length() - 1) {
            extension = filename.substring(dotIndex + 1);
        }
        return extension;

    }



    abstract   List<String>  readContent(String filepath);

    public  void tokenize(List<String> fileContent){

    }
    public  void normalize(List<String> fileContent){

    }
    public void parse(){

    }

    public String getFilepath() {
        return filepath;
    }
    public String getFilename() {
        return filename;
    }
}

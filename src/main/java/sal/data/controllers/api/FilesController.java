package sal.data.controllers.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sal.data.domain.UploadedFile;

@RestController
public class FilesController extends BaseApiController {
    
    @RequestMapping("/files")
    public List<UploadedFile> uploadedFiles() {
    	List<UploadedFile> files = new ArrayList<UploadedFile>();
    	
    	UploadedFile f = new UploadedFile();
    	f.setFileName("File_1.txt");
    	f.setDataSource("FOO");
    	f.setCatalogTag("Mock_Tag_123");
    	f.setTotalCount(100000000L);
    	f.setFileSizeKb(2300L);
    	f.setUploaded(new Date());
    	f.setAccepted(true);
    	files.add(f);
    	
    	f = new UploadedFile();
    	f.setFileName("File_2.txt");
    	f.setDataSource("BAR");
    	f.setCatalogTag("Mock_Tag_456");
    	f.setTotalCount(2300000000L);
    	f.setFileSizeKb(4300L);
    	f.setUploaded(new Date());
    	f.setAccepted(false);
    	files.add(f);
    	
    	f = new UploadedFile();
    	f.setFileName("File_3.txt");
    	f.setDataSource("RAW");
    	f.setCatalogTag("Mock_Tag_789");
    	f.setTotalCount(30000000L);
    	f.setFileSizeKb(73000L);
    	f.setUploaded(new Date());
    	f.setAccepted(true);
    	files.add(f);
    	
        return files;
    }
    
}

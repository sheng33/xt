package service;

import dao.User;
import dao.UserFile;
import dao.UserFileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UserFileDao userFileDao;
    @Override
    public void SaveFileName(UserFile userFile, User user) {
        userFileDao.savefile(userFile.getFilename(),userFile.getFilesrc(),userFile.getNewfilename(),user.getRole());
    }

    @Override
    public UserFile CheckFile(String filename,int role) {
        UserFile userFile = userFileDao.findfileSrc(filename,role);
        if (userFile !=null){
            return userFile;
        }
        return null;
    }

    @Override
    public List<UserFile> ShowList(int role) {
        List<UserFile> userFile = userFileDao.showfilelist(role);
        if( userFile != null){
            return userFile;
        }
        return null;
    }
}

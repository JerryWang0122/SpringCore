package session05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import session05.bean.GuestBook;
import session05.dao.GuestBookDao;

import java.util.List;

@Service
public class GuestBookServiceImpl implements GuestBookService{

    @Autowired
    @Qualifier("gbDao")
    private GuestBookDao guestBookDao;

    @Override
    public boolean add(String userName, String content) {
        GuestBook guestBook = new GuestBook(userName, content);
        return guestBookDao.create(guestBook) == 1;
    }

    @Override
    public GuestBook getById(Integer id) {
        return guestBookDao.findById(id);
    }

    @Override
    public List<GuestBook> queryAll() {
        return guestBookDao.findAll();
    }

    @Override
    public boolean updateUsername(Integer id, String username) {
        GuestBook guestBook = guestBookDao.findById(id);
        if (guestBook == null) {
            return false;
        }
        guestBook.setUserName(username);
        return guestBookDao.update(guestBook) == 1;
    }

    @Override
    public boolean updateContent(Integer id, String content) {
        GuestBook guestBook = guestBookDao.findById(id);
        if (guestBook == null) {
            return false;
        }
        guestBook.setUserName(content);
        return guestBookDao.update(guestBook) == 1;
    }

    @Override
    public boolean removeById(Integer id) {
        return guestBookDao.deleteById(id) == 1;
    }
}

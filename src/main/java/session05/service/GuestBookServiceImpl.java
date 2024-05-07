package session05.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import session05.bean.GuestBook;

import java.util.List;

//@Component
@Service
public class GuestBookServiceImpl implements GuestBookService{
    @Override
    public boolean add(String userName, String content) {
        return false;
    }

    @Override
    public GuestBook getById(Integer id) {
        return null;
    }

    @Override
    public List<GuestBook> queryAll() {
        return null;
    }

    @Override
    public boolean updateUsername(Integer id, String username) {
        return false;
    }

    @Override
    public boolean updateContent(Integer id, String content) {
        return false;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }
}

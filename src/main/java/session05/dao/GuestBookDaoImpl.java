package session05.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import session05.bean.GuestBook;

import java.util.List;

//@Component
@Repository     // 他也是Component，但也同時代表他是"數據庫"資料，在意義上可以更加明確(屬於Repository的Component)
public class GuestBookDaoImpl implements GuestBookDao{
    @Override
    public int create(GuestBook guestBook) {
        return 0;
    }

    @Override
    public GuestBook findById(Integer id) {
        return null;
    }

    @Override
    public List<GuestBook> findAll() {
        return null;
    }

    @Override
    public int update(GuestBook guestBook) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }
}

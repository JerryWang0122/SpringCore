package session05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import session05.bean.GuestBook;

import java.util.Date;
import java.util.List;

// Repository 也是Component，但也同時代表他是"數據庫"資料
// 在意義上可以更加明確(屬於Repository的Component)
@Repository
public class GuestBookDaoImpl implements GuestBookDao{

    @Autowired  // 自動綁定
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(GuestBook guestBook) {
        String sql = "insert into guestbook(username, content) values (?, ?)";
        return jdbcTemplate.update(sql, guestBook.getUserName(), guestBook.getContent());
    }

    @Override
    public GuestBook findById(Integer id) {
        // 絕對不要 select *
        String sql = "select id, username, content, create_date, update_date from guestbook where id = ?";
        try {
            // queryForObject 是針對個體
            // 搜索個體時，若找不到資料會拋異常，而不是產生null
            GuestBook guestBook = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(GuestBook.class), id);
            return guestBook;
        } catch (DataAccessException e) {
            // 訪問不到資料時
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<GuestBook> findAll() {
        String sql = "select id, username, content, create_date, update_date from guestbook order by id";
        // query 則是針對群組
        // 找不到資料會給null
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(GuestBook.class));
    }

    @Override
    public int update(GuestBook guestBook) {
        String sql = "update guestbook set username = ?, content = ?, update_date = ? where id = ?";
        return jdbcTemplate.update(sql, guestBook.getUserName(), guestBook.getContent(), new Date(), guestBook.getId());
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from guestbook where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}

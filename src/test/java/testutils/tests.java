package testutils;

import com.li.utils.BaseDao;
import org.junit.Test;

public class tests {
    @Test
    public void testutil(){
        System.out.println(BaseDao.getConnection());
    }
}

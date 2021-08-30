import com.duming.dao.TeacherMapper;
import com.duming.entity.Teacher;
import com.duming.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class test {
    public static void main(String[] args) {
        SqlSession sqlsession = MyBatisUtils.getSqlsession();
        TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);
    }
}

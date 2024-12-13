package mappers;

import entity.Login;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {
    Login findLoginByLoginIdAndPassword(@Param("loginId") String loginId, @Param("password") String password);
}
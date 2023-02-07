package ee.valiit.back_toytrade.domain.user;

import ee.valiit.back_toytrade.domain.user.role.LoginResponse;
import ee.valiit.back_toytrade.trade.dto.UserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {


    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toDto(User user);


    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    User toEntity(UserDto userDto);

}
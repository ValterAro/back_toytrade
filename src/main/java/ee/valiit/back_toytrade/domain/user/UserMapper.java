package ee.valiit.back_toytrade.domain.user;

import ee.valiit.back_toytrade.trade.dto.LoginResponse;
import ee.valiit.back_toytrade.trade.Status;
import ee.valiit.back_toytrade.trade.dto.UserDto;
import ee.valiit.back_toytrade.trade.dto.UserInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {


    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toDto(User user);


    @Mapping(constant = Status.ACTIVE, target = "status")
    @Mapping(constant = "3", target = "points")
    User toEntity(UserDto userDto);

    @Mapping(constant = Status.ACTIVE, target = "status")
    @Mapping(source = "points", target = "points")
    User toEntity2(UserInfo userInfo);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "role.name", target = "roleName")
    @Mapping(source = "points", target = "points")
    @Mapping(source = "mobile", target = "mobile")
    @Mapping(source = "status", target = "status")
    UserInfo toInfo(User user);

    List<UserInfo> toInfos(List<User> users);

    @InheritConfiguration(name = "toEntity2")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUser(UserInfo userInfo, @MappingTarget User user);


}
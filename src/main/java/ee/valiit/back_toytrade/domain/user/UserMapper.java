package ee.valiit.back_toytrade.domain.user;

import ee.valiit.back_toytrade.trade.dto.LoginResponse;
import ee.valiit.back_toytrade.trade.Status;
import ee.valiit.back_toytrade.trade.dto.NewUserRequest;
import ee.valiit.back_toytrade.trade.dto.UserInfo;
import ee.valiit.back_toytrade.trade.dto.UserRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toDto(User user);

    @Mapping(constant = Status.ACTIVE, target = "status")
    @Mapping(constant = "3", target = "points")
    User toEntity(NewUserRequest newUserRequest);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    UserInfo toInfo(User user);

    List<UserInfo> toInfos(List<User> users);

    @Mapping(constant = Status.ACTIVE, target = "status")
    @Mapping(source = "points", target = "points")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUser(UserRequest userRequest, @MappingTarget User user);
}
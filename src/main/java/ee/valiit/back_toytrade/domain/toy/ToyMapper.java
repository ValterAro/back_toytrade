package ee.valiit.back_toytrade.domain.toy;

import ee.valiit.back_toytrade.trade.Status;
import ee.valiit.back_toytrade.trade.dto.ToyDto;
import ee.valiit.back_toytrade.trade.dto.ToyEditRequest;
import org.mapstruct.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import ee.valiit.back_toytrade.infrastructure.util.PictureUtil;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {PictureUtil.class})
public interface ToyMapper {

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "condition.id", target = "conditionId")
    @Mapping(source = "condition.name", target = "conditionName")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "userUsername")
    @Mapping(source = "picture", target = "picture", qualifiedByName = "byteArrayToString")
    @Mapping(source = "user.mobile", target = "userMobile")
    ToyDto toDto(Toy toy);

    List<ToyDto> toDtos(List<Toy> toys);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] picture) {
        if (picture == null) {
            return null;
        } else {
            return new String(picture);
        }
    }

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "cityId", target = "city.id")
    @Mapping(source = "cityName", target = "city.name")
    @Mapping(source = "conditionId", target = "condition.id")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(constant = Status.ACTIVE, target = "status")
    @Mapping(source = "picture", target = "picture", qualifiedByName = "stringToByteArray")
    Toy toEntity(ToyDto toyDto);

    @Named("stringToByteArray")
    static byte[] stringToByteArray (String picture){
        if (picture == null || "".equals(picture)) {
            return null;
        }
        byte[] bytes = picture.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    @Mapping(constant = Status.ACTIVE, target = "status")
    @Mapping(source = "picture", target = "picture", qualifiedByName = "stringToByteArray")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Toy updateToy(ToyEditRequest toyEditRequest, @MappingTarget Toy toy);
}
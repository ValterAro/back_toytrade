package ee.valiit.back_toytrade.domain.category;

import ee.valiit.back_toytrade.trade.dto.CategoryDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper {

   @Mapping(source = "id", target = "categoryId")
   @Mapping(source = "name", target = "categoryName")
   CategoryDto toDto(Category category);

    List<CategoryDto> toDtos(List<Category> categories);

}
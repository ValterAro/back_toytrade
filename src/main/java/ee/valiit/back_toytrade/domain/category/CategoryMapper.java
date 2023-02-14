package ee.valiit.back_toytrade.domain.category;

import ee.valiit.back_toytrade.trade.Status;
import ee.valiit.back_toytrade.trade.dto.CategoryDto;
import ee.valiit.back_toytrade.trade.dto.NewCategoryRequest;
import org.mapstruct.*;

import java.util.List;

import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper {

   @Mapping(source = "id", target = "categoryId")
   @Mapping(source = "name", target = "categoryName")
   CategoryDto toDto(Category category);

    List<CategoryDto> toDtos(List<Category> categories);

    @Mapping(source = "categoryName", target = "name")
    @Mapping(constant = ACTIVE, target = "status")
    Category toEntity(NewCategoryRequest newCategoryRequest);

}
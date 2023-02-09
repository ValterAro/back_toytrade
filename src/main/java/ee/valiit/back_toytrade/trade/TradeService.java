package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.category.Category;
import ee.valiit.back_toytrade.domain.category.CategoryService;
import ee.valiit.back_toytrade.domain.city.City;
import ee.valiit.back_toytrade.domain.city.CityMapper;
import ee.valiit.back_toytrade.domain.city.CityService;
import ee.valiit.back_toytrade.domain.condition.Condition;
import ee.valiit.back_toytrade.domain.condition.ConditionMapper;
import ee.valiit.back_toytrade.domain.condition.ConditionService;
import ee.valiit.back_toytrade.domain.picture.PictureRepository;
import ee.valiit.back_toytrade.domain.picture.PictureService;
import ee.valiit.back_toytrade.domain.toy.Toy;
import ee.valiit.back_toytrade.domain.user.User;
import ee.valiit.back_toytrade.domain.user.UserService;
import ee.valiit.back_toytrade.trade.dto.CategoryDto;
import ee.valiit.back_toytrade.trade.dto.CityDto;
import ee.valiit.back_toytrade.trade.dto.ConditionDto;
import ee.valiit.back_toytrade.trade.dto.ToyDto;
import ee.valiit.back_toytrade.domain.toy.ToyMapper;
import ee.valiit.back_toytrade.domain.toy.ToyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TradeService {

    @Resource
    private ToyService toyService;

    @Resource
    private ToyMapper toyMapper;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private UserService userService;


    @Resource
    private ConditionMapper conditionMapper;

    @Resource
    private CityService cityService;

    @Resource
    private ConditionService conditionService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private PictureService pictureService;
    private final PictureRepository pictureRepository;

    public TradeService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }


    public List<ToyDto> getAllToys() {
        List<Toy> toys = toyService.findActiveListedToys();
        List<ToyDto> toyDtos = toyMapper.toDtos(toys);

        return toyDtos;
    }


    public void addNewToy(ToyDto toyDto) {
        Toy toy = toyMapper.toEntity(toyDto);
        Optional<User> userById = userService.findUserById(toyDto.getUserId());
        toy.setUser(userById.get());
        Optional<City> cityById = cityService.findCityById(toyDto.getCityId());
        toy.setCity(cityById.get());
        Optional<Condition> conditionById = conditionService.findConditionById(toyDto.getConditionId());
        toy.setCondition(conditionById.get());
        Optional<Category> categoryById = categoryService.findCategoryById(toyDto.getCategoryId());
        toy.setCategory(categoryById.get());

        toyService.addNewToy(toy);
    }


    public List<ToyDto> getToysByCategories(List<CategoryDto> categoryDtos) {
        List<Toy> toys = getToys(categoryDtos);
        return toyMapper.toDtos(toys);
    }

    private List<Toy> getToys(List<CategoryDto> categoryDtos) {
        List<Toy> toys = new ArrayList<>();
        for (CategoryDto dto : categoryDtos) {
            Integer categoryId = dto.getCategoryId();
            if (dto.getIsSelected()) {
                toys.addAll(toyService.findActiveListedToys(categoryId));
            }
        }
        return toys;
    }

    public List<ConditionDto> getAllConditions() {
        List<Condition> allConditions = conditionService.getAllConditions();
        return conditionMapper.toDtos(allConditions);

    }

    public List<CityDto> getAllCities() {
        List<City> allCities = cityService.getAllCities();
        return cityMapper.toDtos(allCities);

    }
}

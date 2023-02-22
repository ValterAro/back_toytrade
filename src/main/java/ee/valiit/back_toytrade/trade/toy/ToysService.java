package ee.valiit.back_toytrade.trade.toy;

import ee.valiit.back_toytrade.domain.category.Category;
import ee.valiit.back_toytrade.domain.category.CategoryService;
import ee.valiit.back_toytrade.domain.city.City;
import ee.valiit.back_toytrade.domain.city.CityService;
import ee.valiit.back_toytrade.domain.condition.Condition;
import ee.valiit.back_toytrade.domain.condition.ConditionService;
import ee.valiit.back_toytrade.domain.toy.Toy;
import ee.valiit.back_toytrade.domain.toy.ToyMapper;
import ee.valiit.back_toytrade.domain.toy.ToyService;
import ee.valiit.back_toytrade.domain.user.User;
import ee.valiit.back_toytrade.domain.user.UserService;
import ee.valiit.back_toytrade.trade.dto.ToyDto;
import ee.valiit.back_toytrade.trade.dto.ToyEditRequest;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static ee.valiit.back_toytrade.trade.Status.DEACTIVATED;

@Service
public class ToysService {

    @Resource
    private ToyService toyService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private CityService cityService;

    @Resource
    private ConditionService conditionService;

    @Resource
    private UserService userService;

    @Resource
    private ToyMapper toyMapper;

    public void addNewToy(ToyDto toyDto) {
        Toy toy = toyMapper.toEntity(toyDto);
        findAndSetUser(toyDto, toy);
        findAndSetCity(toyDto, toy);
        findAndSetCondition(toyDto, toy);
        findAndSetCategory(toyDto, toy);
        toyService.saveToy(toy);
    }

    public ToyDto findToy(Integer toyId) {
        Toy toy = toyService.findToy(toyId);
        return toyMapper.toDto(toy);
    }

    public void editToy(Integer toyId, ToyEditRequest toyEditRequest) {
        Toy toy = toyService.findToy(toyId);
        toyMapper.updateToy(toyEditRequest, toy);
        updateCityIfChanged(toy, toyEditRequest.getCityId());
        updateCategoryIfChanged(toy, toyEditRequest.getCategoryId());
        updateConditionIfChanged(toy, toyEditRequest.getConditionId());
        toyService.saveToy(toy);
    }

    public void deleteToy(Integer toyId) {
        Toy toy = toyService.findToy(toyId);
        setNewToyName(toy);
        toy.setStatus(DEACTIVATED);
        toyService.saveToy(toy);
    }

    private void findAndSetUser(ToyDto toyDto, Toy toy) {
        User user = userService.findUser(toyDto.getUserId());
        toy.setUser(user);
    }

    private void findAndSetCity(ToyDto toyDto, Toy toy) {
        City city = cityService.findCity(toyDto.getCityId());
        toy.setCity(city);
    }

    private void findAndSetCondition(ToyDto toyDto, Toy toy) {
        Condition condition = conditionService.findCondition(toyDto.getConditionId());
        toy.setCondition(condition);
    }

    private void findAndSetCategory(ToyDto toyDto, Toy toy) {
        Category category = categoryService.findCategory(toyDto.getCategoryId());
        toy.setCategory(category);
    }

    private void updateCityIfChanged(Toy toy, Integer toyDtoCityId) {
        if (!toyDtoCityId.equals(toy.getCity().getId())) {
            City city = cityService.findCity(toyDtoCityId);
            toy.setCity(city);
        }
    }

    private void updateCategoryIfChanged(Toy toy, Integer toyDtoCategoryId) {
        if (!toyDtoCategoryId.equals(toy.getCategory().getId())) {
            Category category = categoryService.findCategory(toyDtoCategoryId);
            toy.setCategory(category);
        }
    }

    private void updateConditionIfChanged(Toy toy, Integer toyDtoConditionId) {
        if (!toyDtoConditionId.equals(toy.getCondition().getId())) {
            Condition condition = conditionService.findCondition(toyDtoConditionId);
            toy.setCondition(condition);
        }
    }

    private static void setNewToyName(Toy toy) {
        String currentName = toy.getName();
        String newName = currentName + " (deactivated " + LocalDateTime.now() + ")";
        toy.setName(newName);
    }
}

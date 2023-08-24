package controller;

import entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PositionService;

@RestController
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionService positionService = new PositionService();

    @PostMapping("/add")
    public void add(@RequestBody Position position) {
        positionService.addPosition(position);
    }

    @PostMapping("/update")
    public void update(@RequestBody Position position) {
        positionService.updatePosition(position);
    }

    @GetMapping("/delete")
    public void delete(@RequestBody Position position) {
        positionService.deletePosition(position);
    }
}

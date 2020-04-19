package lk.geeks.controller;

import lk.geeks.dto.ForeignMemberBrrowDTO;
import lk.geeks.dto.ForeignMemberDTO;
import lk.geeks.service.ForeignBookBrrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/foreignbrrows")
public class ForeignMemberBrrowController {

    @Autowired
    private ForeignBookBrrowService foreignBookBrrowService;


    @PostMapping
    int addBooking(@RequestBody ForeignMemberBrrowDTO foreignMemberBrrowDTO){
       return foreignBookBrrowService.save(foreignMemberBrrowDTO);
    }

    @GetMapping
    List<ForeignMemberBrrowDTO> getAll(){
        return foreignBookBrrowService.getAll();
    }

    @GetMapping(value = "/{ID}")
    ForeignMemberBrrowDTO findByID(@PathVariable("ID") Integer ID){
        return  foreignBookBrrowService.findByID(ID);
    }

    @DeleteMapping(value = "/{ID}")
    boolean delete(@PathVariable("ID") Integer ID){

        return foreignBookBrrowService.delete(ID);
    }

    @PutMapping(value = "/{ID}")
    boolean update( @PathVariable("ID") Integer ID, @RequestBody ForeignMemberBrrowDTO foreignMemberBrrowDTO){

        return  foreignBookBrrowService.update(ID,foreignMemberBrrowDTO);

    }

    @PutMapping(value = "/return/{ID}")
    boolean returnBook(@PathVariable("ID") Integer ID){
        return foreignBookBrrowService.returnBoo(ID);
    }

    @GetMapping(path = "/notReturn")
    List<ForeignMemberBrrowDTO> notReturn(){
        return foreignBookBrrowService.notReturn();
    }

    @GetMapping(value = "/byDate/{date}")
    List<ForeignMemberBrrowDTO> findByDate(@PathVariable("date") String date){
        return foreignBookBrrowService.findByDate(date);
    }
}

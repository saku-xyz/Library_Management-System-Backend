package lk.geeks.controller;

import lk.geeks.dto.ForeignMemberDTO;
import lk.geeks.service.ForeignMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/foreignmembers")
/**
 * This is the API for the Control Foreign Members
 */
public class ForeignMemberController {

    @Autowired
    private ForeignMemberService foreignMemberService;

    /**
     * Find Foreign Member By NIC
     * @param NIC Member NIC
     * @return The Foreign Member DTO
     */
    @GetMapping(value = "/{NIC}",produces = {"application/xml", "text/xml"})
    public ForeignMemberDTO findByID(@PathVariable("NIC") String NIC){
        return foreignMemberService.findById(NIC);
    }


    /**
     * Get All Foreign Members
     * @return List of All Foreign Members
     */
    @GetMapping
    public List<ForeignMemberDTO> findAll(){
        return foreignMemberService.findAll();
    }


    /**
     * Save the Foreign Member
     * @param foreignMemberDTO ForeignMemberDTO containing all the information of Foreign Member
     * @return state of save or not
     */
    @PostMapping
    public boolean save(@RequestBody ForeignMemberDTO foreignMemberDTO){

        return foreignMemberService.save(foreignMemberDTO);
    }


    /**
     * Update the Foreign Member
     * @param NIC Foreign Member NIC
     * @param foreignMemberDTO ForeignMemberDTO ForeignMemberDTO containing all the information of Foreign Member
     * @return state of update or not
     */
    @PutMapping(value = "/{NIC}")
    public boolean update(@PathVariable("NIC") String NIC, @RequestBody ForeignMemberDTO foreignMemberDTO){
        return foreignMemberService.update(NIC,foreignMemberDTO);
    }


    /**
     * Delete the Foreign Member
     * @param NIC Foreign Member NIC
     * @return state of delete or not
     */
    @DeleteMapping(value = "/{NIC}")
    public boolean delete(@PathVariable("NIC") String NIC){
        return foreignMemberService.delete(NIC);
    }

    /**
     * Approve Foreign Member
     * @param NIC Foreign Member NIC
     * @return state of Approved or Not
     */
    @PutMapping(value = "/approveMember/{NIC}")
    public boolean approveMember(@PathVariable("NIC") String NIC){
        return foreignMemberService.approveMember(NIC);
    }


    /**
     * Get All Foreign Member Requests
     * @return All foreign member requests
     */
    @GetMapping(value = "/requests")
    public List<ForeignMemberDTO> getRequests(){
        return foreignMemberService.getRequests();
    }
}

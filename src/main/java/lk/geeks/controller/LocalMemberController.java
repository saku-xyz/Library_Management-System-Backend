package lk.geeks.controller;

import lk.geeks.dto.LocalMemberDTO;
import lk.geeks.entity.LocalMember;
import lk.geeks.service.LocalMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/localmemebrs")

/**
 * This is the API for the Control Local Members
 */
public class LocalMemberController {

    @Autowired
    private LocalMemberService localMemberService;


    /**
     * Find Local Member By NIC
     * @param NIC NIC of Local Member
     * @return Local Member DTO
     */
    @GetMapping(value = "/{NIC}",produces = { "application/xml", "text/xml" })
    public LocalMemberDTO findById(@PathVariable("NIC") String NIC){
        return localMemberService.findById(NIC);
    }


    /**
     * Find All Local Members
     * @return List of Local Memeber DTO
     */
    @GetMapping
    public List<LocalMemberDTO> getAll(){
        return localMemberService.findAll();
    }

    /**
     * Save Local Member
     * @param localMemberDTO LocalMemberDTO containing all the information of Local Member
     * @return Sate of Save or Not
     */
    @PostMapping
    public boolean save(@RequestBody LocalMemberDTO localMemberDTO){
        return localMemberService.save(localMemberDTO);
    }

    /**
     * Update Local Member
     * @param localMemberDTO LocalMemberDTO containing all the information of Local Member
     * @return Sate of Update or Not
     */
    @PutMapping(value = "/{NIC}")
    public boolean update(@PathVariable("NIC") String NIC,@RequestBody LocalMemberDTO localMemberDTO){
        return localMemberService.update(NIC,localMemberDTO);
    }

    /**
     * Delete Local Member
     * @param NIC NIC of Local Memebr
     * @return  Sate of Delete or Not
     */
    @DeleteMapping(value = "/{NIC}")
    public boolean delete(@PathVariable("NIC") String NIC){
        return localMemberService.delete(NIC);
    }

}

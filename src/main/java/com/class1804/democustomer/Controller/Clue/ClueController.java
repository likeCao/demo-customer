package com.class1804.democustomer.Controller.Clue;

import com.class1804.democustomer.Service.Clue.ClueService;
import com.class1804.democustomer.pojo.Clue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.zip.CheckedOutputStream;

@Controller
@RequestMapping("/Clue")
public class ClueController {
    @Autowired
    private ClueService clueService;

    /**
     * 添加线索
     */
    @GetMapping("/set")
    public String setClue(){
        Clue clue = new Clue();
        clue.setClue_name(51);
        clue.setClue_state("重新预约");
        clue.setClue_content("重新预约时间，爽约了");
        clue.setClue_product(3);
        clue.setClue_custome(6);
        clue.setClue_userid(100004);
        int count = clueService.setClue(clue) ;
        System.out.println("==================================================");
        System.out.println(count);
        System.out.println("==================================================");
        return "/login";

    }
    /**
     * 按照客户员工产品id查询，时间排序
     */
    @GetMapping("list")
    public String getClueList(){
        Clue clue = new Clue();
        clue.setClue_userid(100004);
        clue.setClue_custome(6);
        clue.setClue_product(3);
        List<Clue> clueList = clueService.getClueList(clue);

        System.out.println("==================================================");
        for(Clue clue1:clueList){
            System.out.println(clue1.toString());
        }
        System.out.println("==================================================");
        return "/thymeleaf/forms" ;
    }


    /**
     * 删除，按照id
     */
    @GetMapping("/database")
    public String datebaseClue(){
        int id = 2 ;
        int count = clueService.databaseClue(id);
        System.out.println("==================================================");
        System.out.println(count);
        System.out.println("==================================================");
        return "/login" ;
    }

    /**
     * 查询线索数量
     */
    @GetMapping("/countAll")
    public String countAll(){
        int userid = 1000001 ;
        int productid = 3 ;
        int count = clueService.getCount(userid,productid) ;
        System.out.println("==================================================");
        System.out.println(count);
        System.out.println("==================================================");
        return "/login" ;
    }

    /**
     * 查询最新更新时间
     */
    @GetMapping("/idAll")
    public String idAll(){
        int userid = 1000001 ;
        int productid = 3 ;
        Clue count = clueService.getidAll(userid,productid) ;
        System.out.println("==================================================");
        System.out.println(count);
        System.out.println("==================================================");
        return "/login" ;
    }
}

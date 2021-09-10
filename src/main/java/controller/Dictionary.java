package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    @GetMapping("/than")
    public String formSearch(){
        return "formsearch";
    }
    @PostMapping("/translate")
    public String wordSearch(@RequestParam String txtSearch, ModelMap modelMap){

        modelMap.put("hello","xin chào");
        modelMap.put("goodbye","tạm biệt");
        modelMap.put("love and be love","Yêu và được yêu");
        modelMap.put("love is the sea of trouble","yêu là bể khổ");
        txtSearch = txtSearch.toLowerCase();
        String vietnamese = (String)modelMap.get(txtSearch);
        if(vietnamese==null){
            vietnamese = "not found";
            modelMap.addAttribute("english",txtSearch);
            modelMap.addAttribute("vietnamese",vietnamese);
        }else {
            modelMap.addAttribute("english",txtSearch);
            modelMap.addAttribute("vietnamese",vietnamese);
        }return "wordsearch";
    }
}

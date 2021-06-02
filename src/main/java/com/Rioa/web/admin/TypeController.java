package com.Rioa.web.admin;

import com.Rioa.po.Type;
import com.Rioa.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                        Model model) {
        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/newtypes")
    public String addInput(Model model) {
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String editType(@PathVariable Long id, Model model) {
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }

    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id) {
        typeService.deleteType(id);
        return "redirect:/admin/types";
    }

    @PostMapping("/addtypes")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
        //NotTheSame
        Type type2 = typeService.getByName(type.getName());
        if(type2 != null) {
            result.rejectValue("name","ErrorName","博客分类不可重复");
        }
        //BackProofread
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        //NotBlank
        Type type1 = typeService.saveType(type);
        if(type1 == null) {
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/types";
    }


}

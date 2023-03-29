package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    List<Grade> studenGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grade", studenGrades);
        return "grades";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {

        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            studenGrades.add(grade);
        } else {
            studenGrades.set(index, grade);
        }
        return "redirect:/grades";
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("grade", getGradeIndex(id) == Constants.NOT_FOUND ? new Grade() : studenGrades.get(getGradeIndex(id)));
        return "form";
    }

    public Integer getGradeIndex(String id) {
        for (int i = 0; i < studenGrades.size(); i++) {
            if (studenGrades.get(i).getId().equals(id))
                return i;
        }
        return Constants.NOT_FOUND;
    }

}

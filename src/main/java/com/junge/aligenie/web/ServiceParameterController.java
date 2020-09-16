package com.junge.aligenie.web;

import com.junge.aligenie.entity.DeviceType;
import com.junge.aligenie.entity.DeviceTypeOperation;
import com.junge.aligenie.entity.parameter.ServiceParameter;
import com.junge.aligenie.repository.DeviceTypeOperationRepository;
import com.junge.aligenie.repository.ServiceParameterRepository;
import com.junge.aligenie.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * mode class
 *
 * @Author LiuJun
 * @Date 2020/9/15 10:59
 */
@RequestMapping("/setting")
@Controller
public class ServiceParameterController {

    @Autowired
    ServiceParameterRepository serviceParameterRepository;

    @Autowired
    DeviceTypeOperationRepository deviceTypeOperationRepository;

    @GetMapping("/serviceParameters")
    @ResponseBody
    public List<ServiceParameter> getServiceParameters(String id){
        //List<ServiceParameter> all = serviceParameterRepository.getServiceParametersByDeviceTypeOperation_Id(id);
//        DeviceTypeOperation deviceTypeOperation = deviceTypeOperationRepository.getDeviceTypeOperationByDeviceType_Id(id);
//        List<ServiceParameter> serviceParameters = deviceTypeOperation.getServiceParameters();
        return  null;
    }


    @PostMapping("/serviceParameter")
    @ResponseBody
    public ReturnT addServiceParameter(@Valid @RequestBody ServiceParameter serviceParameter, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ReturnT(400,bindingResult.getFieldError().getDefaultMessage());
        }
        ServiceParameter save = serviceParameterRepository.save(serviceParameter);
        if(save!=null){
            return new ReturnT(200,"新增成功");
        }
        return new ReturnT(500,"新增失败");
    }
}
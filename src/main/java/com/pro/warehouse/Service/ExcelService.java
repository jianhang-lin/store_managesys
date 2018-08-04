package com.pro.warehouse.Service;

import com.pro.warehouse.Exception.NormalException;
import com.pro.warehouse.util.PoiUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class ExcelService<T> {

    private T t;
    public void ExportEcelService(List<T> excellist,String title,String sheetName,HttpServletResponse response,String filename,Class calzz) throws IllegalAccessException, InstantiationException {
        try {
            PoiUtils.exportExcel(excellist,title,sheetName,calzz,filename,response);
        } catch (NormalException e) {
            e.printStackTrace();
        }
    }
    // PoiUtils.exportExcel(excellist,"花名册","草帽一伙",Person.class,"海贼王.xls",response);

    public List<T> ImportExcelService(MultipartFile file,T t) throws IllegalAccessException, InstantiationException {
        List<T> personList=null;
        try {
            personList = PoiUtils.importExcel(file,1,1,t.getClass());
        } catch (NormalException e) {
            e.printStackTrace();
        }
        return personList;
    }

}
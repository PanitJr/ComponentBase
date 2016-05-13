package ComponentBase.report;

import ComponentBase.order.Order;
import ComponentBase.order.OrderService;
import net.sf.jasperreports.engine.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by panit on 5/12/2016.
 */
@Controller
public class ReportController {
    final static Logger logger = Logger.getLogger(ReportController.class);
    final static String pdfSource = "src/main/resources/static/jasper/report.pdf";
    private void generateReport(List<Order> orders) throws JRException {
        logger.info("[!] Start generate report");
        // Path to our template goes here
        JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/static/jasper/report.jrxml");
        // load data to datasource
        JRDataSource<Order> dataSource = new JRDataSource<Order>().using(orders);
        // Map datasource to template
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<String,Object>(), dataSource);
        // Export to pdf
        JasperExportManager.exportReportToPdfFile(jasperPrint,pdfSource);
    }
    @RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
    public HttpEntity<byte[]> getReport(@PathVariable("id")String id) throws JRException,IOException {
        // Stub data

//        generateReport(orders);
        logger.info("[+] Generated report successfully");

        // Force download
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "pdf"));
        header.set("Content-Disposition",
                "attachment; filename=" + "FileNameHere.pdf");
        byte[] documentBody = Files.readAllBytes(new File(pdfSource).toPath());
        header.setContentLength(documentBody.length);
        return new HttpEntity<byte[]>(documentBody, header);
    }
}
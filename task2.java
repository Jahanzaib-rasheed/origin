package task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class task2 {
	private Workbook workbook;
	
	
public Workbook getTask1wb  (){
	File x;	
	FileInputStream file;
		Workbook wbin=null;
		try{
		x =new File("Output.xlsx");
		file = new FileInputStream(x);
		wbin= new XSSFWorkbook(file);
		file.close();
		}catch (Exception e1){
		try{
			x =new File("Output.xls");
			file = new FileInputStream(x);
			wbin= new HSSFWorkbook(file);
			file.close();
		}catch (Exception e2){
		try{	
			new Task1().ExecuteTask1();
			return new task2().getTask1wb();
		}catch(Exception e3){
			e3.printStackTrace();
			}
		}
		}
		return wbin;	
	}

public List<Sentence> ReadFromFile(){
	List<Sentence> ListSentence=new ArrayList<>();
	workbook = getTask1wb();
	Sheet OutputSheet = workbook.getSheetAt(0);
	Iterator<Row> iterator = OutputSheet.iterator();iterator.next();
	
	while (iterator.hasNext()) {
		Row nextRow = iterator.next();
		Iterator<Cell> cellIterator = nextRow.cellIterator();
		Sentence aSentence = new Sentence();
		
		while (cellIterator.hasNext()) {
			Cell nextCell = cellIterator.next();
			int columnIndex = nextCell.getColumnIndex();
			switch (columnIndex) {
			case 0:
				aSentence.setSentenceID((int) nextCell.getNumericCellValue());
				break;
			case 1:
				aSentence.setRowId((int) nextCell.getNumericCellValue());
				break;
			case 2:
				aSentence.setSentence((String)nextCell.getStringCellValue());
				break;
			}		
		}
		ListSentence.add(aSentence);
	}
	Shuffle(ListSentence);
	return ListSentence;
}

public void Shuffle(List<Sentence>l){
	Collections.shuffle(l);
}

public void WriteInFile(List<Sentence>l){
	CreationHelper createHelper = workbook.getCreationHelper();
	Sheet outputsheet;
	try{
		outputsheet= workbook.createSheet("Output Task 2");
	}catch (Exception e){
		outputsheet=workbook.getSheetAt(1);
	}
    Row Outputrow = outputsheet.createRow((short)0);
    Outputrow.createCell(0).setCellValue(
            createHelper.createRichTextString("sentence_id"));
    Outputrow.createCell(1).setCellValue(
   	        createHelper.createRichTextString("row_id"));
    Outputrow.createCell(2).setCellValue(
   	        createHelper.createRichTextString("Sentence"));
    Outputrow.createCell(3).setCellValue(
            createHelper.createRichTextString("checkbox 1"));
    Outputrow.createCell(4).setCellValue(
   	        createHelper.createRichTextString("checkbox 2"));
    Outputrow.createCell(5).setCellValue(
   	        createHelper.createRichTextString("checkbox 3"));
    Outputrow.createCell(6).setCellValue(
            createHelper.createRichTextString("checkbox 4"));
    Outputrow.createCell(7).setCellValue(
   	        createHelper.createRichTextString("checkbox 5"));
    Outputrow.createCell(8).setCellValue(
   	        createHelper.createRichTextString("checkbox 6"));
    Outputrow.createCell(9).setCellValue(
            createHelper.createRichTextString("checkbox 7"));
    Outputrow.createCell(10).setCellValue(
   	        createHelper.createRichTextString("Skip Count"));
    Outputrow.createCell(11).setCellValue(
   	        createHelper.createRichTextString("Submit Count"));    
    for (int i=0; i<l.size();i++){
			Outputrow = outputsheet.createRow((short)l.get(i).getSentenceID());
			Outputrow.createCell(0).setCellValue(l.get(i).getSentenceID());
		    Outputrow.createCell(1).setCellValue(l.get(i).getRowId());
		    Outputrow.createCell(2).setCellValue(
			         createHelper.createRichTextString(l.get(i).getSentence()));				
		    Outputrow.createCell(3).setCellValue(l.get(i).getChkbox1());
		    Outputrow.createCell(4).setCellValue(l.get(i).getChkbox2());
		    Outputrow.createCell(5).setCellValue(l.get(i).getChkbox3());
		    Outputrow.createCell(6).setCellValue(l.get(i).getChkbox4());
		    Outputrow.createCell(7).setCellValue(l.get(i).getChkbox5());
		    Outputrow.createCell(8).setCellValue(l.get(i).getChkbox6());
		    Outputrow.createCell(9).setCellValue(l.get(i).getChkbox7());
		    Outputrow.createCell(10).setCellValue(l.get(i).getSkip());
		    Outputrow.createCell(11).setCellValue(l.get(i).getSubmit());
		    }
    try{
    FileOutputStream fileOut = new FileOutputStream("Output.xlsx");
    workbook.write(fileOut);
    fileOut.close();
    }catch (Exception e1){
		try{
		    FileOutputStream fileOut = new FileOutputStream("Output.xls");
		    workbook.write(fileOut);
		    fileOut.close();
			}catch (Exception e2){
				e2.printStackTrace();
				System.out.println("Unable to write on Excel file in Project Directory.");
			}
		}
	}
}

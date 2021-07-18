//package com.silentkid.practice;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CodeCase {
//
//
//    public class CSVReader{
//
//        private final FileDefn fileDefn;
//        private final File file;
//
//        public CSVReader(File file, FileDefn fileDefn){
//            this.file = file;
//            this.fileDefn = fileDefn;
//            // check for File size ,throw Illegal Arg exception
//        }
//
//        public RowIterator getRowIterator(){
//            FileBufferReader fbr ;
//            String headerline=fbr.next;
//
//            String[] headers = headerline.split(",");
//            List<IteratorColumnDefn> iterColumns = new ArrayList<>();
//
//            for(int i = 0 ; i < headers.length ; i++){
//                // find header in this.fileDefn.columnDefn
//                for(ColumnDefn column : this.fileDefn.columns){
//                    if(column.name.equals(headers[i])){
//                        iterColumns.add(new IteratorColumnDefn(column , i));
//                    }
//
//                }
//
//            }
//            fbr.close();
//
//            return new RowIterator(file,iterColumns);
//        }
//
//
//    }
//
//    public class RowIterator {
//
//        File file;
//        List<IteratorColumnDefn> columnDefn;
//        IteratorColumnDefn[] index_to_Column;  //if arr[i] is null, i should skip
//        FileBufferReader fbr;
//
//        public RowIterator(File file, List<IteratorColumnDefn> columnDefn){
//            this.file = file;
//            this.columnDefn =  columnDefn;
//            FileBufferReader fbr = new  FileBufferReader(File);
//
//        }
//
//        private openFile(){
//            //if FBR is not init , open it
//        }
//
//        public boolean hasNext(){
//            openFile();
//            return fbr.hasNext;
//        }
//
//        public RowEntry getNext(){
//            openFile();
//
//            String line = fbr.next();
//            String[] columns = line.split(",");
//
//            for(int i =0 ; i < index_to_Column.length ; i++){
//                if(index_to_Column[i] == null){
//                    continue;
//                }
//                IteratorColumnDefn defn= index_to_Column[i];
//
//                ColumnEntry entry= DataTypeFactory.getValue(defn,columns[i] );
//
//            }
//
//
//        }
//
//    }
//
//    public class FileDefn{
//        List<ColumnDefn> columns;
//    }
//
//
//    public class ColumnDefn{
//        String name; //exact
//        DataType dataType;
//    }
//
//    public class IteratorColumnDefn extends ColumnDefn{
//        int index_in_file;
//    }
//
//    public enum DataType {
//        STRING ,
//        INT,
//        LONG
//    }
//
//    public class RowEntry{
//        List<ColumnEntry> columns;
//    }
//
//    public class ColumnEntry<V>{
//        String header;
//        V value;
//    }
//}

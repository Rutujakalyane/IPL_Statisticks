package CSVBuilder;

import IPL.IPLException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCSVBuilder <E> implements ICSVBuilder {
        //    ITERATOR OF CSV FILE
        @Override
        public <E> Iterator<E> getIterator(Reader reader, Class<E> csvClass)  {
            try {
                return this.getCSVToBean(reader, csvClass).iterator();
            }catch (IPLException e){
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public List getCSVFileList(Reader reader, Class csvClass) {
        return null;
    }

    // Return csvtoBean
        private  <E> CsvToBean<E> getCSVToBean(Reader reader, Class<E> csvClass) throws IPLException {
            try {
                CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
                csvToBeanBuilder.withType(csvClass);
                csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                return csvToBeanBuilder.build();
            }  catch (IllegalStateException e) {
                throw new IPLException("Wrong file", IPLException.ExceptionType.NO_CRICKET_DATA);
            }
        }
    }


package CSVBuilder;

import IPL.IPLException;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder {
    <E> Iterator<E> getIterator(Reader reader, Class<E> csvClass) throws IPLException;

    List getCSVFileList(Reader reader, Class csvClass);
}

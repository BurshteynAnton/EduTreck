package antonburshteyn.enums.service;

import antonburshteyn.enums.model.Course;
import antonburshteyn.enums.model.GetSource;
import antonburshteyn.enums.model.GetStatus;
import antonburshteyn.enums.model.Payment;

public interface EnumsService {

    Enum<GetStatus> getEnumStatus(String enumName);

    Enum<Course> getEnumCourse(String enumName);

    Enum<Payment> getEnumPaymentType();

    Enum<GetSource> getEnumSource();

}

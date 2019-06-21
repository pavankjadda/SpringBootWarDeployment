package com.pj.springdatademo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.Month;


@Data
@Entity
@Table(name = "time_period")
public class TimePeriod implements Serializable
{
    private static final long serialVersionUID = 3986913106767316193L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_month")
    private Month startMonth;

    @Min(value = 1800, message = "End Year should not be less than 1800")
    @Max(value = 9999, message = "End Year should not be greater than 9999")
    @Column(name = "start_year", columnDefinition = "INT CHECK start_year>=1800")
    private int startYear;

    @Column(name = "end_month")
    private Month endMonth;

    @Min(value = 1800, message = "End Year should not be less than 1800")
    @Max(value = 9999, message = "End Year should not be greater than 9999")
    @Column(name = "end_year")
    private int endYear;


}

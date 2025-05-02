package com.example.hhruscanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Сгенерировано с помощью Gson на основе доки api.hhru
 */
@NoArgsConstructor
@Data
public class Vacancy {

    @JsonProperty("accept_handicapped")
    private Boolean acceptHandicapped;
    @JsonProperty("accept_incomplete_resumes")
    private Boolean acceptIncompleteResumes;
    @JsonProperty("accept_kids")
    private Boolean acceptKids;
    @JsonProperty("accept_temporary")
    private Boolean acceptTemporary;
    @JsonProperty("address")
    private AddressDTO address;
    @JsonProperty("allow_messages")
    private Boolean allowMessages;
    @JsonProperty("alternate_url")
    private String alternateUrl;
    @JsonProperty("apply_alternate_url")
    private String applyAlternateUrl;
    @JsonProperty("approved")
    private Boolean approved;
    @JsonProperty("archived")
    private Boolean archived;
    @JsonProperty("area")
    private AreaDTO area;
    @JsonProperty("billing_type")
    private BillingTypeDTO billingType;
    @JsonProperty("branded_description")
    private String brandedDescription;
    @JsonProperty("branded_template")
    private BrandedTemplateDTO brandedTemplate;
    @JsonProperty("can_upgrade_billing_type")
    private Boolean canUpgradeBillingType;
    @JsonProperty("code")
    private String code;
    @JsonProperty("contacts")
    private ContactsDTO contacts;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("department")
    private DepartmentDTO department;
    @JsonProperty("description")
    private String description;
    @JsonProperty("driver_license_types")
    private List<DriverLicenseTypesDTO> driverLicenseTypes;
    @JsonProperty("employer")
    private EmployerDTO employer;
    @JsonProperty("employment")
    private EmploymentDTO employment;
    @JsonProperty("experience")
    private ExperienceDTO experience;
    @JsonProperty("expires_at")
    private String expiresAt;
    @JsonProperty("has_test")
    private Boolean hasTest;
    @JsonProperty("hidden")
    private Boolean hidden;
    @JsonProperty("id")
    private String id;
    @JsonProperty("initial_created_at")
    private String initialCreatedAt;
    @JsonProperty("insider_interview")
    private InsiderInterviewDTO insiderInterview;
    @JsonProperty("internship")
    private Boolean internship;
    @JsonProperty("key_skills")
    private List<KeySkillsDTO> keySkills;
    @JsonProperty("languages")
    private List<LanguagesDTO> languages;
    @JsonProperty("manager")
    private ManagerDTO manager;
    @JsonProperty("name")
    private String name;
    @JsonProperty("night_shifts")
    private Boolean nightShifts;
    @JsonProperty("premium")
    private Boolean premium;
    @JsonProperty("professional_roles")
    private List<ProfessionalRolesDTO> professionalRoles;
    @JsonProperty("published_at")
    private String publishedAt;
    @JsonProperty("response_letter_required")
    private Boolean responseLetterRequired;
    @JsonProperty("response_notifications")
    private Boolean responseNotifications;
    @JsonProperty("response_url")
    private Object responseUrl;
    @JsonProperty("salary")
    private SalaryDTO salary;
    @JsonProperty("salary_range")
    private SalaryRangeDTO salaryRange;
    @JsonProperty("schedule")
    private ScheduleDTO schedule;
    @JsonProperty("test")
    private TestDTO test;
    @JsonProperty("type")
    private TypeDTO type;
    @JsonProperty("video_vacancy")
    private VideoVacancyDTO videoVacancy;
    @JsonProperty("work_format")
    private List<WorkFormatDTO> workFormat;
    @JsonProperty("work_schedule_by_days")
    private List<WorkScheduleByDaysDTO> workScheduleByDays;
    @JsonProperty("working_days")
    private List<WorkingDaysDTO> workingDays;
    @JsonProperty("working_hours")
    private List<WorkingHoursDTO> workingHours;
    @JsonProperty("working_time_intervals")
    private List<WorkingTimeIntervalsDTO> workingTimeIntervals;
    @JsonProperty("working_time_modes")
    private List<WorkingTimeModesDTO> workingTimeModes;

    @NoArgsConstructor
    @Data
    public static class AddressDTO {
        @JsonProperty("building")
        private String building;
        @JsonProperty("city")
        private String city;
        @JsonProperty("description")
        private String description;
        @JsonProperty("lat")
        private Double lat;
        @JsonProperty("lng")
        private Double lng;
        @JsonProperty("metro_stations")
        private List<MetroStationsDTO> metroStations;
        @JsonProperty("street")
        private String street;

        @NoArgsConstructor
        @Data
        public static class MetroStationsDTO {
            @JsonProperty("lat")
            private Double lat;
            @JsonProperty("line_id")
            private String lineId;
            @JsonProperty("line_name")
            private String lineName;
            @JsonProperty("lng")
            private Double lng;
            @JsonProperty("station_id")
            private String stationId;
            @JsonProperty("station_name")
            private String stationName;
        }
    }

    @NoArgsConstructor
    @Data
    public static class AreaDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("url")
        private String url;
    }

    @NoArgsConstructor
    @Data
    public static class BillingTypeDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class BrandedTemplateDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class ContactsDTO {
        @JsonProperty("email")
        private String email;
        @JsonProperty("name")
        private String name;
        @JsonProperty("phones")
        private List<PhonesDTO> phones;

        @NoArgsConstructor
        @Data
        public static class PhonesDTO {
            @JsonProperty("city")
            private String city;
            @JsonProperty("comment")
            private Object comment;
            @JsonProperty("country")
            private String country;
            @JsonProperty("number")
            private String number;
        }
    }

    @NoArgsConstructor
    @Data
    public static class DepartmentDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class EmployerDTO {
        @JsonProperty("alternate_url")
        private String alternateUrl;
        @JsonProperty("badges")
        private List<BadgesDTO> badges;
        @JsonProperty("blacklisted")
        private Boolean blacklisted;
        @JsonProperty("id")
        private String id;
        @JsonProperty("logo_urls")
        private LogoUrlsDTO logoUrls;
        @JsonProperty("name")
        private String name;
        @JsonProperty("trusted")
        private Boolean trusted;
        @JsonProperty("url")
        private String url;

        @NoArgsConstructor
        @Data
        public static class LogoUrlsDTO {
            @JsonProperty("90")
            private String $90;
            @JsonProperty("240")
            private String $240;
            @JsonProperty("original")
            private String original;
        }

        @NoArgsConstructor
        @Data
        public static class BadgesDTO {
            @JsonProperty("description")
            private String description;
            @JsonProperty("position")
            private String position;
            @JsonProperty("type")
            private String type;
            @JsonProperty("url")
            private String url;
            @JsonProperty("year")
            private Integer year;
        }
    }

    @NoArgsConstructor
    @Data
    public static class EmploymentDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class ExperienceDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class InsiderInterviewDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("url")
        private String url;
    }

    @NoArgsConstructor
    @Data
    public static class ManagerDTO {
        @JsonProperty("id")
        private String id;
    }

    @NoArgsConstructor
    @Data
    public static class SalaryDTO {
        @JsonProperty("currency")
        private String currency;
        @JsonProperty("from")
        private Integer from;
        @JsonProperty("gross")
        private Boolean gross;
        @JsonProperty("to")
        private Object to;
    }

    @NoArgsConstructor
    @Data
    public static class SalaryRangeDTO {
        @JsonProperty("currency")
        private String currency;
        @JsonProperty("frequency")
        private FrequencyDTO frequency;
        @JsonProperty("from")
        private Integer from;
        @JsonProperty("gross")
        private Boolean gross;
        @JsonProperty("mode")
        private ModeDTO mode;
        @JsonProperty("to")
        private Object to;

        @NoArgsConstructor
        @Data
        public static class FrequencyDTO {
            @JsonProperty("id")
            private String id;
            @JsonProperty("name")
            private String name;
        }

        @NoArgsConstructor
        @Data
        public static class ModeDTO {
            @JsonProperty("id")
            private String id;
            @JsonProperty("name")
            private String name;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ScheduleDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class TestDTO {
        @JsonProperty("required")
        private Boolean required;
    }

    @NoArgsConstructor
    @Data
    public static class TypeDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class VideoVacancyDTO {
        @JsonProperty("cover_picture")
        private CoverPictureDTO coverPicture;
        @JsonProperty("video_url")
        private String videoUrl;

        @NoArgsConstructor
        @Data
        public static class CoverPictureDTO {
            @JsonProperty("resized_height")
            private Integer resizedHeight;
            @JsonProperty("resized_path")
            private String resizedPath;
            @JsonProperty("resized_width")
            private Integer resizedWidth;
        }
    }

    @NoArgsConstructor
    @Data
    public static class DriverLicenseTypesDTO {
        @JsonProperty("id")
        private String id;
    }

    @NoArgsConstructor
    @Data
    public static class KeySkillsDTO {
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class LanguagesDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("level")
        private LevelDTO level;
        @JsonProperty("name")
        private String name;

        @NoArgsConstructor
        @Data
        public static class LevelDTO {
            @JsonProperty("id")
            private String id;
            @JsonProperty("name")
            private String name;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ProfessionalRolesDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class WorkFormatDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class WorkScheduleByDaysDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class WorkingDaysDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class WorkingHoursDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class WorkingTimeIntervalsDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class WorkingTimeModesDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }
}


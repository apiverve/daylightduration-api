// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     DaylightDurationCalculatorData data = Converter.fromJsonString(jsonString);

package com.apiverve.daylightduration.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static DaylightDurationCalculatorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(DaylightDurationCalculatorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(DaylightDurationCalculatorData.class);
        writer = mapper.writerFor(DaylightDurationCalculatorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// DaylightDurationCalculatorData.java

package com.apiverve.daylightduration.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.time.OffsetTime;

public class DaylightDurationCalculatorData {
    private LocalDate date;
    private Location location;
    private String condition;
    private String description;
    private OffsetTime sunrise;
    private String sunset;
    private DaylightDuration daylightDuration;
    private long dayOfYear;
    private boolean isValid;

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("location")
    public Location getLocation() { return location; }
    @JsonProperty("location")
    public void setLocation(Location value) { this.location = value; }

    @JsonProperty("condition")
    public String getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(String value) { this.condition = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("sunrise")
    public OffsetTime getSunrise() { return sunrise; }
    @JsonProperty("sunrise")
    public void setSunrise(OffsetTime value) { this.sunrise = value; }

    @JsonProperty("sunset")
    public String getSunset() { return sunset; }
    @JsonProperty("sunset")
    public void setSunset(String value) { this.sunset = value; }

    @JsonProperty("daylight_duration")
    public DaylightDuration getDaylightDuration() { return daylightDuration; }
    @JsonProperty("daylight_duration")
    public void setDaylightDuration(DaylightDuration value) { this.daylightDuration = value; }

    @JsonProperty("day_of_year")
    public long getDayOfYear() { return dayOfYear; }
    @JsonProperty("day_of_year")
    public void setDayOfYear(long value) { this.dayOfYear = value; }

    @JsonProperty("is_valid")
    public boolean getIsValid() { return isValid; }
    @JsonProperty("is_valid")
    public void setIsValid(boolean value) { this.isValid = value; }
}

// DaylightDuration.java

package com.apiverve.daylightduration.data;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetTime;

public class DaylightDuration {
    private double totalMinutes;
    private long hours;
    private long minutes;
    private OffsetTime formatted;

    @JsonProperty("total_minutes")
    public double getTotalMinutes() { return totalMinutes; }
    @JsonProperty("total_minutes")
    public void setTotalMinutes(double value) { this.totalMinutes = value; }

    @JsonProperty("hours")
    public long getHours() { return hours; }
    @JsonProperty("hours")
    public void setHours(long value) { this.hours = value; }

    @JsonProperty("minutes")
    public long getMinutes() { return minutes; }
    @JsonProperty("minutes")
    public void setMinutes(long value) { this.minutes = value; }

    @JsonProperty("formatted")
    public OffsetTime getFormatted() { return formatted; }
    @JsonProperty("formatted")
    public void setFormatted(OffsetTime value) { this.formatted = value; }
}

// Location.java

package com.apiverve.daylightduration.data;

import com.fasterxml.jackson.annotation.*;

public class Location {
    private double latitude;
    private double longitude;

    @JsonProperty("latitude")
    public double getLatitude() { return latitude; }
    @JsonProperty("latitude")
    public void setLatitude(double value) { this.latitude = value; }

    @JsonProperty("longitude")
    public double getLongitude() { return longitude; }
    @JsonProperty("longitude")
    public void setLongitude(double value) { this.longitude = value; }
}
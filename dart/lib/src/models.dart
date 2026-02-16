/// Response models for the Daylight Duration Calculator API.

/// API Response wrapper.
class DaylightdurationResponse {
  final String status;
  final dynamic error;
  final DaylightdurationData? data;

  DaylightdurationResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory DaylightdurationResponse.fromJson(Map<String, dynamic> json) => DaylightdurationResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DaylightdurationData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Daylight Duration Calculator API.

class DaylightdurationData {
  String? date;
  DaylightdurationDataLocation? location;
  String? condition;
  String? description;
  String? sunrise;
  String? sunset;
  DaylightdurationDataDaylightDuration? daylightDuration;
  int? dayOfYear;
  bool? isValid;

  DaylightdurationData({
    this.date,
    this.location,
    this.condition,
    this.description,
    this.sunrise,
    this.sunset,
    this.daylightDuration,
    this.dayOfYear,
    this.isValid,
  });

  factory DaylightdurationData.fromJson(Map<String, dynamic> json) => DaylightdurationData(
      date: json['date'],
      location: json['location'] != null ? DaylightdurationDataLocation.fromJson(json['location']) : null,
      condition: json['condition'],
      description: json['description'],
      sunrise: json['sunrise'],
      sunset: json['sunset'],
      daylightDuration: json['daylight_duration'] != null ? DaylightdurationDataDaylightDuration.fromJson(json['daylight_duration']) : null,
      dayOfYear: json['day_of_year'],
      isValid: json['is_valid'],
    );
}

class DaylightdurationDataLocation {
  double? latitude;
  double? longitude;

  DaylightdurationDataLocation({
    this.latitude,
    this.longitude,
  });

  factory DaylightdurationDataLocation.fromJson(Map<String, dynamic> json) => DaylightdurationDataLocation(
      latitude: json['latitude'],
      longitude: json['longitude'],
    );
}

class DaylightdurationDataDaylightDuration {
  double? totalMinutes;
  int? hours;
  int? minutes;
  String? formatted;

  DaylightdurationDataDaylightDuration({
    this.totalMinutes,
    this.hours,
    this.minutes,
    this.formatted,
  });

  factory DaylightdurationDataDaylightDuration.fromJson(Map<String, dynamic> json) => DaylightdurationDataDaylightDuration(
      totalMinutes: json['total_minutes'],
      hours: json['hours'],
      minutes: json['minutes'],
      formatted: json['formatted'],
    );
}

class DaylightdurationRequest {
  double latitude;
  double longitude;
  String? date;

  DaylightdurationRequest({
    required this.latitude,
    required this.longitude,
    this.date,
  });

  Map<String, dynamic> toJson() => {
      'latitude': latitude,
      'longitude': longitude,
      if (date != null) 'date': date,
    };
}

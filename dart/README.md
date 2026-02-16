# Daylight Duration Calculator API - Dart/Flutter Client

Daylight Duration Calculator computes sunrise, sunset times, and total daylight hours for any geographic location and date using astronomical algorithms.

[![pub package](https://img.shields.io/pub/v/apiverve_daylightduration.svg)](https://pub.dev/packages/apiverve_daylightduration)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Daylight Duration Calculator API](https://apiverve.com/marketplace/daylightduration?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_daylightduration: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_daylightduration/apiverve_daylightduration.dart';

void main() async {
  final client = DaylightdurationClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'latitude': 40.7128,
      'longitude': -74.006,
      'date': 'today'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "date": "2024-06-21",
    "location": {
      "latitude": 40.7128,
      "longitude": -74.006
    },
    "condition": "Normal",
    "description": "Standard sunrise and sunset",
    "sunrise": "09:25:09",
    "sunset": "24:30:44",
    "daylight_duration": {
      "total_minutes": 905.58,
      "hours": 15,
      "minutes": 5,
      "formatted": "15:05:00"
    },
    "day_of_year": 173,
    "is_valid": true
  }
}
```

## API Reference

- **API Home:** [Daylight Duration Calculator API](https://apiverve.com/marketplace/daylightduration?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/daylightduration](https://docs.apiverve.com/ref/daylightduration?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)

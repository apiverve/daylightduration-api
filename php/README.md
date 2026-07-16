# Daylight Duration Calculator API - PHP Package

Daylight Duration Calculator computes sunrise, sunset times, and total daylight hours for any geographic location and date using astronomical algorithms.

## Installation

Install via Composer:

```bash
composer require apiverve/daylightduration
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Daylightduration\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'latitude' => 40.7128,
    'longitude' => -74.006,
    'date' => '2024-06-21'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Daylightduration\Client;
use APIVerve\Daylightduration\Exceptions\APIException;
use APIVerve\Daylightduration\Exceptions\ValidationException;

try {
    $response = $client->execute(['latitude' => 40.7128, 'longitude' => -74.006, 'date' => '2024-06-21']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/daylightduration?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/daylightduration?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/daylightduration?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).

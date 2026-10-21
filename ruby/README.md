# Daylight Duration Calculator API - Ruby Gem

Daylight Duration Calculator computes sunrise, sunset times, and total daylight hours for any geographic location and date using astronomical algorithms.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_daylightduration'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_daylightduration
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_daylightduration'

# Initialize the client
client = APIVerve::Daylightduration::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  latitude: 40.7128,
  longitude: -74.006,
  date: "2024-06-21"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ latitude: 40.7128, longitude: -74.006, date: "2024-06-21" })
  puts response["data"]
rescue APIVerve::Daylightduration::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Daylightduration::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Daylightduration::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/daylightduration?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/daylightduration?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/daylightduration?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).

Daylight Duration Calculator API
============

Daylight Duration Calculator computes sunrise, sunset times, and total daylight hours for any geographic location and date using astronomical algorithms.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [Daylight Duration Calculator API](https://apiverve.com/marketplace/api/daylightduration)

---

## Installation
	pip install apiverve-daylightdurationcalculator

---

## Configuration

Before using the daylightduration API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Daylight Duration Calculator API documentation is found here: [https://docs.apiverve.com/api/daylightduration](https://docs.apiverve.com/api/daylightduration).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
# Import the client module
from apiverve_daylightdurationcalculator.apiClient import DaylightdurationAPIClient

# Initialize the client with your APIVerve API key
api = DaylightdurationAPIClient("[YOUR_API_KEY]")
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
query = { "latitude": 40.7128, "longitude": -74.0060, "date": "2024-06-21" }
```

###### Simple Request

```
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```
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

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
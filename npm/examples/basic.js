/**
 * Basic Example - Daylight Duration Calculator API
 *
 * This example demonstrates how to use the Daylight Duration Calculator API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const daylightdurationAPI = require('../index.js');

// Initialize the API client
const api = new daylightdurationAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  latitude: 40.7128,
  longitude: -74.0060,
  date: "2024-06-21"
};

// Make the API request using callback
console.log('Making request to Daylight Duration Calculator API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});

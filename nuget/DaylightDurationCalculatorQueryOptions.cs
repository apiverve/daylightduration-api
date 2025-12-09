using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.DaylightDurationCalculator
{
    /// <summary>
    /// Query options for the Daylight Duration Calculator API
    /// </summary>
    public class DaylightDurationCalculatorQueryOptions
    {
        /// <summary>
        /// Latitude of the location (-90 to 90)
        /// Example: 40.7128
        /// </summary>
        [JsonProperty("latitude")]
        public string Latitude { get; set; }

        /// <summary>
        /// Longitude of the location (-180 to 180)
        /// Example: -74.0060
        /// </summary>
        [JsonProperty("longitude")]
        public string Longitude { get; set; }

        /// <summary>
        /// Date in YYYY-MM-DD format (defaults to today)
        /// Example: 2024-06-21
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }
    }
}

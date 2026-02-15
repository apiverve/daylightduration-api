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
        /// Latitude of the location
        /// </summary>
        [JsonProperty("latitude")]
        public string Latitude { get; set; }

        /// <summary>
        /// Longitude of the location
        /// </summary>
        [JsonProperty("longitude")]
        public string Longitude { get; set; }

        /// <summary>
        /// Date in YYYY-MM-DD format (defaults to today)
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }
    }
}

declare module '@apiverve/daylightduration' {
  export interface daylightdurationOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface daylightdurationResponse {
    status: string;
    error: string | null;
    data: DaylightDurationCalculatorData;
    code?: number;
  }


  interface DaylightDurationCalculatorData {
      date:             Date;
      location:         Location;
      condition:        string;
      description:      string;
      sunrise:          string;
      sunset:           string;
      daylightDuration: DaylightDuration;
      dayOfYear:        number;
      isValid:          boolean;
  }
  
  interface DaylightDuration {
      totalMinutes: number;
      hours:        number;
      minutes:      number;
      formatted:    string;
  }
  
  interface Location {
      latitude:  number;
      longitude: number;
  }

  export default class daylightdurationWrapper {
    constructor(options: daylightdurationOptions);

    execute(callback: (error: any, data: daylightdurationResponse | null) => void): Promise<daylightdurationResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: daylightdurationResponse | null) => void): Promise<daylightdurationResponse>;
    execute(query?: Record<string, any>): Promise<daylightdurationResponse>;
  }
}

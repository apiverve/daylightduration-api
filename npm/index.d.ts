declare module '@apiverve/daylightduration' {
  export interface daylightdurationOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface daylightdurationResponse {
    status: string;
    error: string | null;
    data: DaylightDurationCalculatorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface DaylightDurationCalculatorData {
      date:             Date | null;
      location:         Location;
      condition:        null | string;
      description:      null | string;
      sunrise:          null | string;
      sunset:           null | string;
      daylightDuration: DaylightDuration;
      dayOfYear:        number | null;
      isValid:          boolean | null;
  }
  
  interface DaylightDuration {
      totalMinutes: number | null;
      hours:        number | null;
      minutes:      number | null;
      formatted:    null | string;
  }
  
  interface Location {
      latitude:  number | null;
      longitude: number | null;
  }

  export default class daylightdurationWrapper {
    constructor(options: daylightdurationOptions);

    execute(callback: (error: any, data: daylightdurationResponse | null) => void): Promise<daylightdurationResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: daylightdurationResponse | null) => void): Promise<daylightdurationResponse>;
    execute(query?: Record<string, any>): Promise<daylightdurationResponse>;
  }
}

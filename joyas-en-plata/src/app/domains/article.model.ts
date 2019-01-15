export class Article {
    title: string;
    link: string;
    votes: number;

    constructor(title: string, link: string, votes?: number) {
        const url = 'http://';
        this.title = title;
        this.link = url.concat(link);
        this.votes = votes;
    }

    voteUp(): void {
        this.votes += 1;
    }
    voteDown(): void {
        this.votes -= 1;
    }

    // domain() is a utility function that extracts
    // the domain from a URL, which we'll explain shortly
    domain(): string {
        try {
            // e.g. http://foo.com/path/to/bar
            const domainAndPath: string = this.link.split('//')[1];
            console.log('domain1: ' + this.link);
            // e.g. foo.com/path/to/bar
            console.log('domain2: ' + domainAndPath.split('/')[0]);
            return domainAndPath.split('/')[0];
        } catch (err) {
            return null;
        }
    }
}

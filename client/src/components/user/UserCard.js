import React from "react";
import styled from "styled-components";

const UserItem = styled.div`
  display: flex;
  flex-direction: column;
  overflow: hidden;
  padding: 5px 6px 7px 7px;
  color: hsl(210deg 8% 45%);
  .div {
    display: flex;
  }
`;

const UserAvatar = styled.img`
  width: 48px;
  height: 48px;
  border-radius: 2px;
`;

const UserDetails = styled.div`
  margin-left: 9px;
  height: 20px;
  font-size: 15px;
  a {
    text-decoration: none;
    outline: none;
    display: block;
    margin-bottom: 5px;
    color: hsl(206deg 100% 40%);
    &:hover {
      color: #0a95ff;
      cursor: pointer;
    }
  }
  span {
    display: block;
    margin-bottom: 5px;
  }
`;

const UserLocation = styled.span`
  margin-top: 5px;
  color: #6a737c;
  font-size: 12px;
  margin: 0 0 2px;
`;

const UserReputation = styled.span`
  margin: 5px 0 5px;
  color: #6a737c;
  font-size: 12px;
  font-weight: bold;
`;

const UserBadge = styled.div`
  display: flex;
  color: #838c95;
  font-size: 12px;
  margin: 5px 0 2px 57px;
`;

const Badges = styled.span`
  display: flex;
  align-items: center;
  justify-content: center;
  .gold-badge {
    margin-right: 3px;
    width: 6px;
    height: 6px;
    background: #ffcc01;
    border-radius: 50%;
  }
  .silver-badge {
    margin-right: 3px;
    margin-left: 8px;
    width: 6px;
    height: 6px;
    background: #b4b8be;
    border-radius: 50%;
  }
  .bronze-badge {
    margin-right: 3px;
    margin-left: 8px;
    width: 6px;
    height: 6px;
    background: #d2a685;
    border-radius: 50%;
  }
`;

export default function UserCard({
  profile,
  link,
  name,
  reputation,
  gold,
  silver,
  bronze,
  location,
}) {
  return (
    <UserItem>
      <div className="div">
        <UserAvatar src={profile} />
        <UserDetails>
          <a href={link}>{name}</a>
          <UserLocation>{location}</UserLocation>
          <UserReputation>
            {reputation.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}
          </UserReputation>
        </UserDetails>
      </div>
      <UserBadge>
        <Badges>
          <span className="gold-badge" />
          <span>{gold}</span>
        </Badges>
        <Badges>
          <span className="silver-badge" />
          <span>{silver}</span>
        </Badges>
        <Badges>
          <span className="bronze-badge" />
          <span>{bronze}</span>
        </Badges>
      </UserBadge>
    </UserItem>
  );
}
